
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Get_Member_Zy_Information : ServiceBase
    {
        public RJZ_Get_Member_Zy_Information()
        {
            this.sqlStr = "Get_Member_Zy_Information";
        }
        /// <summary>
        /// 通过选择的成员来查询成员住院基础信息
        /// </summary>
        /// <param name="SqlStr">Get_Member_Zy_Information</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&D401_10&D401_21&DEP_ID

        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D401_10 VARCHAR2(18)	取存储过的的新医疗证号
        // D401_21 CHAR(2)	取存储过的成员序号
        // DEP_ID VARCHAR2(22)	用户所在单位编码

        // 0	成功
        // 1	失败  未找到该信息
        // 成功返回：
        // S_Returns=0;D504_03;D504_04;D504_01;D504_05;D504_06;D504_08;D401_13;D504_10;D504_11;D504_16;D504_19;D504_07;D504_02;D505_COSTS;D505_REDEEMABLE;D504_21;D505_SELFPAY;D506_25;CHSJ;D506_23_JT;D506_23_GR;DIAGNOSIS_NAME;SBSJ;D401_04;IDENTITY

    }
}



