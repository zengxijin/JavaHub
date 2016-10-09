using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_Get_Member_Information_Rydj : ServiceBase
    {
        public ZYBC_Get_Member_Information_Rydj()
        {
            this.sqlStr = "Get_Member_Information_Rydj";
        }
        
        /// <summary>
        /// 查询基础人员信息
        /// </summary>
        /// <param name="SqlStr">Get_Member_Information_Rydj</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        
        // AREA_NO&D401_10&D401_21
        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D401_10 VARCHAR2(18)	取存储过的的新医疗证号
        // D401_21 CHAR(2)	取存储过的成员序号


        // 0	成功
        // 1	失败  未找到该信息
        // 成功返回：
        // S_Returns=0;D401_10; D401_21;D401_02; XB;D401_03;D401_01;AGE;D401_13; INP_DATE;IDENTITY




    }
}
