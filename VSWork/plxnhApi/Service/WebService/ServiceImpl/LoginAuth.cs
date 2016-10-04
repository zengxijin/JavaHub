using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl
{
    public class LoginAuth : ServiceBase
    {
        /// <summary>
        /// 登录验证
        /// </summary>
        /// <param name="SqlStr">PROC_CHECK_USER</param>
        /// <param name="parames">USER_CODE&USER_PASS 用户名和密码</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        public string executeSql(string SqlStr, string parames, string split)
        {
            this.sqlStr  = SqlStr;
            this.parames = parames;
            this.split   = split;

            return this.executeResult = ServiceInvoke.Update_Data_String(SqlStr, parames, split);
        }

        public string getExecuteResultPlainString()
        {
            return this.executeResult;
        }

        public Dictionary<string, string> getExecuteResultWrapperMap()
        {
            if (string.IsNullOrEmpty(this.executeResult) == false)
            {
                string[] array = this.executeResult.Split(new string[] { this.split }, StringSplitOptions.None);
                Dictionary<string, string> wrapper = new Dictionary<string, string>();
                //说明：登录成功后返回的变量字符串为：
                //S_Returns=0;USER_ID;USER_CODE;USER_PASS;USER_NAME;DEP_ID;USER_TEL;DEP_NAME;DEP_AREA;USER_JG;DEP_LEVEL;AREA_CODE;T_IS_FLASH_AUTHORIZED;T_YEARS;T_IS_SK;T_IS_SK_HOSP;T_IS_XJ;T_RJZ_DATE;T_CH_START_DATE;T_CH_END_DATE;T_DY_MX_IS_HZ;T_IS_BLUSH_DAY;T_BLUSH_DAY;
                wrapper.Add("", "");
            }

            return null;
        }

    }
}
