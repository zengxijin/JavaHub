
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Get_S301_06_Zy : ServiceBase
    {
        public RJZ_Get_S301_06_Zy()
        {
            this.sqlStr = "Get_S301_06_Zy";
        }
        
        /// <summary>
        /// 取出住院补偿类别
        /// </summary>
        /// <param name="SqlStr">Get_S301_06_Zy</param>
        /// <param name="parames">AREA_NO 病人地区编码(取前台选择的地区编码)</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // 0	成功
        // 1	失败  未找到该信息
        // 成功返回：
        // S_Returns=0;ITEM_CODE/ ITEM_NAME; ITEM_CODE/ ITEM_NAME
        // ITEM_CODE：VARCHAR2(3)   补偿类别编码
        // ITEM_NAME：VARCHAR2(64)  补偿类别名称

    }
}
 