using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.MZBC
{
    public class MZBC_Get_Member_Information : ServiceBase
    {
        public MZBC_Get_Member_Information()
        {
            this.sqlStr = "Get_Member_Information";
        }
        
        /// <summary>
        /// 查询基础人员信息
        /// </summary>
        /// <param name="SqlStr">Get_Member_Information</param>
        /// <param name="parames">AREA_NO&D401_10&D401_21</param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>
        
		//AREA_NO	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
		//D401_10 VARCHAR2(18)	取存储过的的新医疗证号
		//D401_21 CHAR(2)	取存储过的成员序号

		
		//成功返回：S_Returns=0;D401_02;D401_01;SEX;AGE;D401_13;NAMENATIONAL;D601_17;D503_17;TC_REMAIN;GRLB;JTLB;D401_04  (分号分隔)


    }
}
