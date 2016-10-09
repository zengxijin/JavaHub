
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Find_New_Ylzh : ServiceBase
    {
        public RJZ_Find_New_Ylzh()
        {
            this.sqlStr = "Find_New_Ylzh";
        }
        
        /// <summary>
        /// 同时需要根据住院号查询出医疗证号(以遍下一步用)
        /// </summary>
        /// <param name="SqlStr">Find_New_Ylzh</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&DEP_ID&D504_09

        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // DEP_ID VARCHAR2(22)	用户所在单位编码
        // D504_09	VARCHAR2(12)	住院号



        // 0	成功
        // 1	失败
        // 成功：S_Returns =0;D401_10  (分号分隔)
        // D401_10： VARCHAR2(18)  新医疗证号 需要存储

    }
}
