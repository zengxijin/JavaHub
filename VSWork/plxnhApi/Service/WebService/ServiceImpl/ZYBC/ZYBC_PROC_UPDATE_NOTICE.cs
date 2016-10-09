
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_PROC_UPDATE_NOTICE : ServiceBase
    {
        public ZYBC_PROC_UPDATE_NOTICE()
        {
            this.sqlStr = "PROC_UPDATE_NOTICE";
        }
        
        /// <summary>
        /// 修改入院登记
        /// </summary>
        /// <param name="SqlStr">PROC_UPDATE_NOTICE</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_CODE&D504_01&D504_21&D504_09&D504_10&D504_19&D504_16&D504_11&D504_28

        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_01 VARCHAR2(24)	住院登记流水号
        // D504_21	VARCHAR2(40)	疾病代码
        // D504_09	VARCHAR2(12)	住院号
        // D504_10	CHAR(1)	就诊类型
        // D504_19	CHAR(1)	入院状态代码(对应S301-02.xls)
        // D504_16	VARCHAR2(4)	入院科室代码（对应S201-03.xls）
        // D504_11	DATE	入院时间(格式为YYYY-MM-DD)
        // D504_28	VARCHAR2(12)	联系电话

        // 0	成功
        // 1	失败 
        // 修改成功： S_Returns= 0
        // 修改失败： S_Returns= 1;错误信息   （分号分隔）




    }
}


