using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl
{
    public class MZBC_Get_Member : ServiceBase
    {
        /// <summary>
        /// 根据新医疗证号查询家庭成员
        /// </summary>
        /// <param name="SqlStr">Get_Member</param>
        /// <param name="parames">AREA_NO&D401_10 病人地区编码(取前台选择的地区编码)&医疗证号</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        public string executeSql(string SqlStr, string parames, string split)
        {
            this.sqlStr  = SqlStr;
            this.parames = parames;
            this.split   = split;

            return this.executeResult = ServiceInvoke.Execute_Sql(SqlStr, parames, split);
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
                //成功：S_Returns =0;D401_10 VARCHAR2(18) （分号分隔）
                //注：D401_10医疗证号需要存储，以便以后使用。
                //失败：S_Returns =1  卡号不存在
                wrapper.Add("", "");
            }
            return null;
        }

    }
}
