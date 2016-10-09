
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Zycz : ServiceBase
    {
        public RJZ_Zycz()
        {
            this.sqlStr = "Zycz";
        }
        /// <summary>
        /// 住院冲正
        /// </summary>
        /// <param name="SqlStr">Zycz</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_NO&D505_02&IS_SAVE
        // AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D505_02	VARCHAR2(24)	登记流水号
        // IS_SAVE		是否保留入院登记  yes 保留  no 不保留



        // 0	成功
        // 1	失败
        // 冲正成功：S_Returns=0;D504_01
        // D504_01：VARCHAR2(24)  住院登记流水号
        // 冲正失败：S_Returns= 1;错误信息   (分号分隔)


    }
}
 