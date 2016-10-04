
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
        public static string Update_Data_String(string procName,string parames,string split) 
        {
            return getWebSoapClient().Update_Data_String(procName, parames, split);
        }

        public static string Execute_Sql(string sqlStr,string parames,string split)
        {
            return getWebSoapClient().Execute_Sql(sqlStr, parames, split);
        }

        private static Data_Update_MSoapClient getWebSoapClient()
        {
            return new Data_Update_MSoapClient();
        }
    }
}
