package com.ayp.sms.shiroSecurity;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 *
 * @author rana
 */
public class JoomlaCredientalsMatcher implements CredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken at, AuthenticationInfo ai) {

        char[] tokenpass = (char[]) at.getCredentials();
        char[] crediental = (char[]) ai.getCredentials();

        // play with default Sha256Hash first
        Sha256Hash hashAlgo = new Sha256Hash(tokenpass);
        boolean passed = true;
        String dbhash = new String(crediental);

        if (!dbhash.toLowerCase().equals(hashAlgo.toHex().toLowerCase())) {
            passed = false;
        }

        if (passed == false) {
            // try joomla password type as well
            String browserpass = new String(tokenpass);
            // get salt from crediental
            int pos = dbhash.indexOf(':')+1;
            // compare hash
            if ((pos>0) && (pos < dbhash.length())) {
                String salt = dbhash.substring(pos);
                String hashType = browserpass+salt;
                Md5Hash md5hash = new Md5Hash(hashType);
                String hash= dbhash.substring(0,pos-1);
                
                if (md5hash.toHex().toLowerCase().equals(hash.toLowerCase()))
                {
                    passed=true;
 
                }
                
            } else {
                return false;
            }
            
        }
        return passed;
    }

}
