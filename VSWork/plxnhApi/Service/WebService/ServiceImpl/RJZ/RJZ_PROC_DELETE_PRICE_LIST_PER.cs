
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_PROC_DELETE_PRICE_LIST_PER : ServiceBase
    {
        public RJZ_PROC_DELETE_PRICE_LIST_PER()
        {
            this.sqlStr = "PROC_DELETE_PRICE_LIST_PER";
        }
        /// <summary>
        /// 作废单个收费项目
        /// </summary>
        /// <param name="SqlStr">PROC_DELETE_PRICE_LIST_PER</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_CODE&D504_01&HIS_ID
        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_01	VARCHAR2(24)	住院登记流水号
        // HIS_ID	NUMBER(12)	对应HIS项目唯一ID


        // 0	成功
        // 1	程序异常
        // 删除成功：S_Returns= 0
        // 删除失败：S_Returns= 1;错误信息   (分号分隔)




    }
}
 