
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.SK
{
    public class SK_Get_Is_Hops_Sk : ServiceBase
    {
        public SK_Get_Is_Hops_Sk()
        {
            this.sqlStr = "Get_Is_Hops_Sk";
        }
        
        /// <summary>
        /// 判断此医疗机构是否刷卡
        /// </summary>
        /// <param name="SqlStr">Get_Is_Hops_Sk</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&DEP_ID
        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // DEP_ID VARCHAR2(22)	用户所在医院编码

        // 0	成功
        // 1	失败
        // 成功则返回
        // S_Returns=0     可以继续刷卡
        // 失败则返回
        // S_Returns=1;请给此医疗机构授权刷卡！   (分号分隔)


    }
}
 