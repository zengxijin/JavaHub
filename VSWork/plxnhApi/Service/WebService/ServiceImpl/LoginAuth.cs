using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service.WebService.ServiceImpl
{
    public class LoginAuth : IService
    {
        string IService.executeSql(string SqlStr, string parames, string split)
        {
            throw new NotImplementedException();
        }

        string IService.getExecuteResultPlainString()
        {
            throw new NotImplementedException();
        }

        Dictionary<string, string> IService.getExecuteResultWrapperMap()
        {
            throw new NotImplementedException();
        }

        bool IService.getExecuteStatus()
        {
            throw new NotImplementedException();
        }
    }
}
