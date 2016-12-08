package activitiTest.test;

import org.activiti.ldap.LDAPConfigurator;
 
public class LDAPConfiguration {

    public LDAPConfigurator LDAPConfig(){
        LDAPConfigurator ldapConfig = new LDAPConfigurator();
         
        ldapConfig.setServer("ldap://quark.com");
        ldapConfig.setPort(389);
        ldapConfig.setUser("name=Xijin Zeng,ou=QuarkFinance");
        ldapConfig.setPassword("Password123");
         
        ldapConfig.setBaseDn("");
        ldapConfig.setQueryUserByUserId("(&(objectClass=inetOrgPerson)(uid={0}))");
        ldapConfig.setQueryUserByFullNameLike("(&(objectClass=inetOrgPerson)(|({0}=*{1}*)({2}=*{3}*)))");
        ldapConfig.setQueryGroupsForUser("(&(objectClass=groupOfUniqueNames)(uniqueMember={0}))");
         
        ldapConfig.setUserIdAttribute("uid");
        ldapConfig.setUserFirstNameAttribute("cn");
        ldapConfig.setUserLastNameAttribute("sn");
         
        ldapConfig.setGroupIdAttribute("cn");
        ldapConfig.setGroupNameAttribute("cn");
         
        return ldapConfig;
    }
}
