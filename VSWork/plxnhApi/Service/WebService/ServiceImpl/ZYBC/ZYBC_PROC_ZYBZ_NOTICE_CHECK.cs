using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_PROC_ZYBZ_NOTICE_CHECK : ServiceBase
    {
        public ZYBC_PROC_ZYBZ_NOTICE_CHECK()
        {
            this.sqlStr = "PROC_ZYBZ_NOTICE_CHECK";
        }
        
        /// <summary>
        /// 验证本人是否已经住院
        /// </summary>
        /// <param name="SqlStr">PROC_ZYBZ_NOTICE_CHECK</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        //AREA_NO&D401_10&D401_21&DEP_ID
        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D401_10 VARCHAR2(18)	取存储过的的新医疗证号
        // D401_21 CHAR(2)	取存储过的成员序号
        // DEP_ID VARCHAR2(22)	取存储过的用户单位ID

        // 0	成功
        // 1	此病人在本院已经做过入院登记
        // 2	此病人在其他医院已经做过入院登记
        // 3	程序异常
        // 此病人在其他医院已经做过入院登记：  2;医院名称（分号分隔）
        // 程序异常： 						    3;错误信息（分号分隔）



    }
}