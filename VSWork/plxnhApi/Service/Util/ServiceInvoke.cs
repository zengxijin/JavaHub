
using Service.ServiceReference1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.Util
{
    public class ServiceInvoke
    {
        public static string Update_Data_String() 
        {
            Data_Update_MSoapClient client = new Data_Update_MSoapClient();
            string retVal = client.Update_Data_String("PROC_ZYBZ_NOTICE_CHECK", "AREA_NO&D401_10&D401_21&DEP_ID", "&");
            
            return "";
        }
    }
}
