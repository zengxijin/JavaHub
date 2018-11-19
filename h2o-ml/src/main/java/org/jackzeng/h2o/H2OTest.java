package org.jackzeng.h2o;

import hex.tree.gbm.GBM;
import hex.tree.gbm.GBMModel;
import water.H2O;
import water.H2OApp;
import water.Key;
import water.fvec.Frame;
import water.fvec.NFSFileVec;
import water.parser.ParseDataset;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author xijin.zeng created on 2018/10/31
 */
public class H2OTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String h2oargs = "-nthreads -1 ";
        H2OApp.main(h2oargs.split(" "));
        System.out.println("Starting H2O with IP "+H2O.getIpPortString());

        H2O.waitForCloudSize(1, 3000);

        System.out.println("Loading data from file ");
        String inputfile = args[0];
        NFSFileVec datafile = NFSFileVec.make(inputfile);
        Frame dataframe = ParseDataset.parse(Key.make("dataset-key") , datafile._key);
        System.out.println("Loaded file "+inputfile+" size "+datafile.byteSize()+" Cols:"+dataframe.numCols()+" Rows:"+dataframe.numRows());


        for (int v=0; v<dataframe.numCols(); v++) {
            System.out.println(dataframe.name(v)+" "+dataframe.vec(v).get_type_str());
        }

        int c = dataframe.find("bad_loan");

        dataframe.replace(c, dataframe.vec(c).toCategoricalVec());


        // drop the id and member_id columns from model
        dataframe.remove(dataframe.find("id"));
        dataframe.remove(dataframe.find("member_id"));

        System.out.println("Creating GBM Model");

        GBMModel.GBMParameters modelparms = new GBMModel.GBMParameters();
        modelparms._train = dataframe._key;
        modelparms._response_column = "bad_loan";

        System.out.println("Training Model");
        GBM model = new GBM(modelparms);
        GBMModel gbm = model.trainModel().get();

        System.out.println("Training Results");
        System.out.println(gbm._output);
        System.out.println("Model AUC "+gbm.auc());


        String outputfile = inputfile+".zip";
        FileOutputStream modeloutput = new FileOutputStream(outputfile);
        gbm.getMojo().writeTo(modeloutput);
        modeloutput.close();
        System.out.println("Model written out as a mojo to file "+outputfile);

        System.out.println("H2O shutdown....");
        H2O.shutdown(0);

    }
}
