
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.SK
{
    public class SK_Get_Is_Sk : ServiceBase
    {
        public SK_Get_Is_Sk()
        {
            this.sqlStr = "Get_Is_Sk";
        }
        /// <summary>
        /// 判断此地区是否刷卡
        /// </summary>
        /// <param name="SqlStr">Get_Is_Sk</param>
        /// <param name="parames">AREA_NO 病人地区编码(取前台选择的地区编码)</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // S_Returns（出参说明）：
        // S_Returns=T_COUNT; SK_TYPE
        // T_COUNT=0 不刷卡，手工输入
        // T_COUNT=1 并且SK_TYPE=1 只能读卡
        // T_COUNT=1 并且SK_TYPE=2 即能读卡又能手工输入
        // T_COUNT=1 并且SK_TYPE=3 查询时不刷卡，收费时二次刷卡验证时刷卡
        // T_COUNT=1 并且SK_TYPE=4 县外住院不刷卡， 县内和门诊刷卡

    }
}
 