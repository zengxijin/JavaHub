
using Service.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl.RJZ
{
    public class RJZ_Save_Row : ServiceBase
    {
        public RJZ_Save_Row()
        {
            this.sqlStr = "Save_Row";
        }
        
        /// <summary>
        /// 保存药品
        /// </summary>
        /// <param name="SqlStr">Save_Row</param>
        /// <param name="parames"></param>
        /// <param name="split">分割符&</param>
        /// <returns></returns>

        // D505_02&COME_AREA&AREA_CODE&D505_04&D505_08&D505_07&D505_09&D505_ID_HIS& USER_ID& D504_14&USER_NAME&LEVEL

        // D505_02 VARCHAR2(24)	住院登记流水号
        // COME_AREA VARCHAR2(6)	地区代码(医疗机构)
        // AREA_CODE	VARCHAR2(6)	病人地区编码(取前台选择的地区编码)
        // D505_04	VARCHAR2(64)	收费项目编码组合(此处因药品可能是多个，药品编码和下一个药品编码用分号分隔(下面的数量、单价、比例、收费项目唯一ID也一样)
        // D505_08	NUMBER(6,2)	收费项目数量组合
        // D505_07	NUMBER(12,6)	收费项目单价组合
        // D505_09	NUMBER(3,2)	收费项目比例组合
        // D505_ID_HIS	NUMBER(12)	收费项目唯一ID组合(对应HIS)
        // USER_ID NUMBER(8)	当前操作员id
        // D504_14 VARCHAR2(22)	诊治单位代码
        // USER_NAME USER_NAME	操作员姓名
        // LEVEL CHAR(1)	诊治单位级别




        // 0	成功
        // 1	程序异常
        // 保存成功：S_Returns=0;d505_01;TOTAL_COSTS ;TOTAL_CHAGE;ZF_COSTS  (分号分隔)
        // d505_01：VARCHAR2(24)  住院处方流水号
        // TOTAL_COSTS ：NUMBER(8,2)  住院总费用
        // TOTAL_CHAGE：NUMBER(8,2)   住院可补偿金额
        // ZF_COSTS：NUMBER(8,2)    住院自费费用
        // 保存失败：S_Returns=1;错误信息   (分号分隔)


    }
}
 