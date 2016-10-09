using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.ZYBC
{
    public class ZYBC_PROC_NEW_NOTICE : ServiceBase
    {
        public ZYBC_PROC_NEW_NOTICE()
        {
            this.sqlStr = "PROC_NEW_NOTICE";
        }
        /// <summary>
        /// 保存入院登记
        /// </summary>
        /// <param name="SqlStr">PROC_NEW_NOTICE</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // COME_AREA&AREA_CODE&D401_10&D504_02&D504_03&D504_04&D504_05&D504_06&D504_21&D504_09&D504_10&D504_11&D504_14&D504_19&D504_16&D504_28
        // COME_AREA VARCHAR2(6)	医疗机构所在地区编码(取用户所在机构地区编码AREA_CODE)
        // AREA_CODE	VARCHAR2(6)	地区代码(病人所在地区编码)取前台选择的地区编码
        // D401_10 VARCHAR2(18)	医疗证号
        // D504_02 VARCHAR2(2)	个人编号
        // D504_03 VARCHAR2(24)	姓名
        // D504_04 CHAR(1)	性别（1：男 2：女）传代码
        // D504_05 VARCHAR2(18)	身份证号
        // D504_06 VARCHAR2(3)	年龄
        // D504_21	VARCHAR2(40)	疾病代码
        // D504_09	VARCHAR2(12)	住院号
        // D504_10	CHAR(1)	就诊类型代码（对应s301_05.xls）
        // D504_11	DATE	入院时间(格式为YYYY-MM-DD)
        // D504_14 VARCHAR2(22)	就医机构代码=DEP_ID
        // D504_19	CHAR(1)	入院状态代码 (对应S301-02.xls)
        // D504_16	VARCHAR2(4)	入院科室代码（对应S201-03.xls）
        // D504_28	VARCHAR2(12)	病人联系电话

        // 0	成功
        // 1	失败 
        // 保存成功：S_Returns= 0;D504_01
        // D504_01：VARCHAR2(24)  住院登记流水号
        // 保存失败： S_Returns= 1;错误信息  （分号分隔）



    }
}



