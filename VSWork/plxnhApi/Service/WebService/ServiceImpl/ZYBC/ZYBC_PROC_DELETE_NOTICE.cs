
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_PROC_DELETE_NOTICE : ServiceBase
    {
        public ZYBC_PROC_DELETE_NOTICE()
        {
            this.sqlStr = "PROC_DELETE_NOTICE";
        }
        /// <summary>
        /// 删除入院登记
        /// </summary>
        /// <param name="SqlStr">PROC_DELETE_NOTICE</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_CODE&D504_01

        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_01 VARCHAR2(24)	住院登记流水号

        // 0	成功
        // 1	失败 
        // 删除成功： S_Returns= 0
        // 删除失败：S_Returns= 1;错误信息   （分号分隔）

    }
}