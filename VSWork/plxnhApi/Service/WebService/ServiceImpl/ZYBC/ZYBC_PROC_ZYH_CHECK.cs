using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_PROC_ZYH_CHECK : ServiceBase
    {
        public ZYBC_PROC_ZYH_CHECK()
        {
            this.sqlStr = "PROC_ZYH_CHECK";
        }
        /// <summary>
        /// 验证住院号是否重复
        /// </summary>
        /// <param name="SqlStr">PROC_ZYH_CHECK</param>
        /// <param name="parames">DEP_ID&D504_09</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>


        // DEP_ID VARCHAR2(22)	所住医院代码(取存储过的用户单位ID)
        // D504_09	VARCHAR2(12)	所输住院号

        // 0	成功
        // 1	住院号重复  
        // 2	程序异常
        // 成功：S_Returns= 0   住院号不重复
        // 住院号重复： S_Returns= 1
        // 程序异常：S_Returns= 2;错误信息   （分号分隔）



    }
}


