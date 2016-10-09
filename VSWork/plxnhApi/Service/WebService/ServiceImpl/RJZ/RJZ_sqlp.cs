
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_sqlp : ServiceBase
    {
        public RJZ_sqlp()
        {
            this.sqlStr = "sqlp";
        }
        
        /// <summary>
        /// 滞后理赔(保险公司)
        /// </summary>
        /// <param name="SqlStr">sqlp</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&D504_01&USER_NAME
        // AREA_NO	VARCHAR2(6)	病人地区编码
        // D504_01	VARCHAR2(24)	登记流水号
        // USER_NAME	VARCHAR2(64)	用户姓名




        // 0	成功
        // 1	失败
        // 申请理赔失败返回参数：
        // S_Returns=1;错误信息
        // 申请理赔成功返回参数说明：
        // S_Returns=0;redeemRe_01//redeemRe_02//redeemRe_03//redeemRe_04//redeemRe_05//redeemRe_06//redeemRe_07//redeemRe_08//redeemRe_09//redeemRe_10//redeemRe_11//redeemRe_12
        // 成功例子：0;1//2//2014//620621//123//100//RMB//////1000//02//2014-03-04



    }
}
 