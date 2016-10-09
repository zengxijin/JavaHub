using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_Get_New_Ylzh : ServiceBase
    {
        public ZYBC_Get_New_Ylzh()
        {
            this.sqlStr = "Get_New_Ylzh";
        }
        
        /// <summary>
        /// 根据旧医疗证号查询家庭成员
        /// </summary>
        /// <param name="SqlStr">Get_New_Ylzh</param>
        /// <param name="parames">AREA_NO&D401_10_TEMP(旧医疗证号) 病人地区编码(取前台选择的地区编码)&旧医疗证号</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        
        // 0	成功
        // 1	失败    卡号不存在
        // 成功：S_Returns =0;D401_10 (分号分隔)
        // D401_10 VARCHAR2(18)  新医疗证号



    }
}


