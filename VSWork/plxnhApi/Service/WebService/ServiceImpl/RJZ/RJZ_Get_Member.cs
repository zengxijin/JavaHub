
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Get_Member : ServiceBase
    {
        public RJZ_Get_Member()
        {
            this.sqlStr = "Get_Member";
        }
        
        /// <summary>
        /// 根据新医疗证号查询家庭成员：(此方法可以不用，可以直接使用 根据住院号查询家庭成员 的方法)
        /// </summary>
        /// <param name="SqlStr">Get_Member</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&D401_10(新医疗证号)

        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D401_10	VARCHAR2(18)	医疗证号

        // 0	成功
        // 1	失败
        // 成功：S_Returns =0;家庭成员字符集
        // 如 0; D401_21/ D401_02; D401_21/ D401_02
        // 成员序号：D401_21   VARCHAR2(2)
        // 成员姓名：D401_02   VARCHAR2(24)
        // 成员序号D401_21需要存储

    }
}