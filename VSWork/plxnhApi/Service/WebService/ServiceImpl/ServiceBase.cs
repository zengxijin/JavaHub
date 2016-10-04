using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl
{
    class ServiceBase : IService
    {
        private string _sqlStr;
        /// <summary>
        /// 执行的服务标识
        /// </summary>
        public string sqlStr
        {
            get
            {
                return _sqlStr;
            }
            set
            {
                _sqlStr = value;
            }
        }
        
        private string _parames;
        /// <summary>
        /// 请求参数
        /// </summary>
        public string parames
        {
            get
            {
                return _parames;
            }
            set
            {
                _parames = value;
            }
        }

        private string _split;
        public string split
        {
            get
            {
                return _split;
            }
            set
            {
                _split = value;
            }
        }

        private string _executeResult;
        /// <summary>
        /// 执行结果
        /// </summary>
        public string executeResult
        {
            get
            {
                return _executeResult;
            }
            set
            {
                _executeResult = value;
            }
        }

        public string executeSql(string SqlStr, string parames, string split)
        {
            throw new NotImplementedException();
        }

        public string getExecuteResultPlainString()
        {
            throw new NotImplementedException();
        }

        public Dictionary<string, string> getExecuteResultWrapperMap()
        {
            throw new NotImplementedException();
        }
        /// <summary>
        /// 根据接口文档的描述，返回结果第一个字符为0即为成功
        /// 默认实现，其他业务场景可以改写此方法
        /// </summary>
        /// <returns></returns>
        public bool getExecuteStatus()
        {
            if (string.IsNullOrEmpty(executeResult) == false)
            {
                if (executeResult.Substring(0, 1) == "0")
                    return true;
            }

            return false;
        }
    }
}
