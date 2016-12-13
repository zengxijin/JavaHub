package activitiTest.test;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestCallDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String url  = (String) execution.getVariable("url");
		System.out.println(url);
        HttpGet httpget = new HttpGet(url);
 
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
        	response = httpclient.execute(httpget);
 
            //activiti-engine V6 API 
            //execution.setTransientVariable("response", IOUtils.toString(response.getEntity().getContent(), "UTF-8"));
            //execution.setTransientVariable("responseStatus", response.getStatusLine().getStatusCode());
            String content = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
            execution.setVariable("restResponse", content);
            execution.setVariable("restCode", response.getStatusLine().getStatusCode());
            
 
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	if(response !=null){
        		response.close();
        	}
        }
	}

}
