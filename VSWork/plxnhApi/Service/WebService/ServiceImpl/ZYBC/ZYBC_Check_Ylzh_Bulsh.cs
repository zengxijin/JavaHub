using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_Check_Ylzh_Bulsh : ServiceBase
    {
        public ZYBC_Check_Ylzh_Bulsh()
        {
            this.sqlStr = "Check_Ylzh_Bulsh";
        }
        /// <summary>
        /// 验证此卡号是否存在
        /// </summary>
        /// <param name="SqlStr">Check_Ylzh_Bulsh</param>
        /// <param name="parames">AREA_NO&M_MM 病人地区编码(取前台选择的地区编码)&读卡的加密串</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        
        // 0	成功
        // 1	失败
        // 成功：S_Returns =0;D401_10 （分号分隔）
        // 注：D401_10  VARCHAR2(18)  医疗证号需要存储，以便以后使用。
        // 失败：S_Returns =1  卡号不存在

    }
}

