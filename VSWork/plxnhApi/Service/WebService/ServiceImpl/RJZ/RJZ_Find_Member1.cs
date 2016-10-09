
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Find_Member1 : ServiceBase
    {
        public RJZ_Find_Member1()
        {
            this.sqlStr = "Find_Member1";
        }
        /// <summary>
        /// 根据住院号查询家庭成员
        /// </summary>
        /// <param name="SqlStr">Find_Member1</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&DEP_ID&D504_09

        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // DEP_ID VARCHAR2(22)	用户所在单位编码
        // D504_09	VARCHAR2(12)	住院号


        // 0	成功
        // 1	失败 
        // 成功：S_Returns =0;家庭成员字符集
        // 如 0; D401_21/ D401_02   （住院号查询出来家庭成员只有一个）
        // 成员序号：D401_21  VARCHAR2(2)
        // 成员姓名：D401_02  VARCHAR2(24)
        // 成员序号D401_21需要存储


    }
}
