using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.MZBC
{
    public class MZBC_Check_Ylzh_Bulsh : ServiceBase
    {
        /// <summary>
        /// 验证此卡号是否存在
        /// </summary>
        /// <param name="SqlStr">Check_Ylzh_Bulsh</param>
        /// <param name="parames">AREA_NO&M_MM 病人地区编码(取前台选择的地区编码)&读卡的加密串</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        
        public MZBC_Check_Ylzh_Bulsh()
        {
            this.sqlStr = "Check_Ylzh_Bulsh";
        }

    }
}
