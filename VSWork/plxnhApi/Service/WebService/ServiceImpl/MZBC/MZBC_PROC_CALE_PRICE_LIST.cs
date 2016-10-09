using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.MZBC
{
    public class MZBC_PROC_CALE_PRICE_LIST : ServiceBase
    {
        public MZBC_PROC_CALE_PRICE_LIST()
        {
            this.sqlStr = "PROC_CALE_PRICE_LIST";
        }
        
        /// <summary>
        /// 试算以及收费
        /// </summary>
        /// <param name="SqlStr">PROC_CALE_PRICE_LIST</param>
        /// <param name="parames">DIAGNOSIS_CODE 疾病代码</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
       
		
        //入参：AREA_NO&D401_10&D401_21&DEP_ID&D501_16&D503_15&DEP_LEVEL&D503_16&D501_10&USER_ID&FLAG&D502_04&D502_09&D502_08&D502_10&D501_13&D501_14&D501_15&D503_03&D503_08&D503_09&OUTP_FACC&SELF_PAY&D501_09&D503_18&HOSP_NAME& D601_17_OUT&XY_OUT&ZCAOY_OUT&ZCHENGY_OUT

        //S_Returns=0;O_TOTAL_COSTS;O_ZF_COSTS;O_TOTAL_CHAGE;O_OUTP_FACC;O_OUT_JJ;O_D503_09; D601_17_OUT; XY_OUT; ZCAOY_OUT; ZCHENGY_OUT
        //0	成功(试算或者收费)
        //1	药品明细保存失败
        //2	试算失败
        //3	收费失败

        // 药品保存失败：S_Returns=1;错误信息   （分号分隔）
        // 试算失败：S_Returns= 2; 错误信息    （分号分隔）
        // 收费成功： S_Returns= 0;T_D502_01   （分号分隔）
        // T_D502_01：门诊登记流水号，此号要存储，以便后面打印补偿凭据的时候用。
        // 收费失败： S_Returns= 3;错误信息    （分号分隔）



    }
}


