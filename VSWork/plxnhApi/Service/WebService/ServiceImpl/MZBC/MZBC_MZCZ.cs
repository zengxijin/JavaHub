using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.MZBC
{
    public class MZBC_MZCZ : ServiceBase
    {
        public MZBC_MZCZ()
        {
            this.sqlStr = "MZCZ";
        }
        /// <summary>
        /// 门诊冲正
        /// </summary>
        /// <param name="SqlStr">MZCZ</param>
        /// <param name="parames">AREA_NO&T_D502_01 病人地区编码(取前台选择的地区编码)&取存储过的门诊登记流水号</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        
        // 0	成功
        // 1	失败  
        // 冲正失败： S_Returns =1;错误信息   (分号分隔)
    }
}



