using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace ApiMonitor
{
    /// <summary>
    /// Data_Update_M 的摘要说明
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // 若要允许使用 ASP.NET AJAX 从脚本中调用此 Web 服务，请取消注释以下行。 
    // [System.Web.Script.Services.ScriptService]
    public class Data_Update_M : System.Web.Services.WebService
    {

        [WebMethod]
        public string Update_Data_String(string proc_name, string parames, string split)
        {
            return proc_name + parames + split;
        }

        [WebMethod]
        public string Execute_Sql(string Sql_Str, string parames, string split)
        {
            return Sql_Str + parames + split;
        }
    }
}
