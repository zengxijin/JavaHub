
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_PROC_DELETE_PRICE_LIST : ServiceBase
    {
        public RJZ_PROC_DELETE_PRICE_LIST()
        {
            this.sqlStr = "PROC_DELETE_PRICE_LIST";
        }
        /// <summary>
        /// 删除收费项目
        /// </summary>
        /// <param name="SqlStr">PROC_DELETE_PRICE_LIST</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // AREA_CODE&D504_01&START_DATE&END_DATE
        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D504_01	VARCHAR2(24)	住院登记流水号
        // START_DATE	VARCHAR2(10)	收费项目录入起始时间(为空时传’NULL’) (格式为YYYY-MM-DD)
        // END_DATE	VARCHAR2(10)	收费项目录入结束时间(为空时传’NULL’) (格式为YYYY-MM-DD)

        // 0	成功
        // 1	程序异常
        // 删除成功：S_Returns= 0
        // 删除失败：S_Returns= 1;错误信息  (分号分隔)



    }
}
 