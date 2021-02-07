package com.xm6leefun.ocpayprogram.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlychain.signsdk.utils.OcMath;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.WalletFile;
import party.loveit.bip44forjava.core.ECKey;

/**
 * wdh
 * OC主网钱包工具类
 */
public class OcWalletUtil {
    /**
     * 设定64位私钥
     *
     * @param hex
     * @return
     */
    private static String to64PrivKeyStr(String hex) {
        return addZeroForNum(hex, 64);
    }

    /**
     * 补位
     *
     * @param str
     * @param strLength
     * @return
     */
    private static String addZeroForNum(String str, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append("0").append(str);// 左补0
                // sb.append(str).append("0");//右补0
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }



    /**
     * 根据keystore导入钱包
     *
     * @param passWords
     * @param keyStoreJson
     * @return 明文的私钥、公钥、地址、keystore、密码
     * @throws CipherException
     */
    public static OcKeysInfo importWalletByKeyStore(String passWords, String keyStoreJson) {
        OcKeysInfo mOcKeysInfo = new OcKeysInfo();
        try {
            ObjectMapper om = new ObjectMapper();
            WalletFile walletFile = om.readValue(keyStoreJson, WalletFile.class);
            ECKeyPair keyPair = HWallet.decrypt(passWords, walletFile);
            ECKey ecKey = ECKey.fromPrivate(keyPair.getPrivateKey());

            mOcKeysInfo.setPrivateKey(to64PrivKeyStr(OcMath.toHexStringNoPrefix(ecKey.getPrivKey())));
            mOcKeysInfo.setPublicKey(OcMath.toHexStringNoPrefix(ecKey.getPubKey()));
            mOcKeysInfo.setAddress(walletFile.getAddress());
            mOcKeysInfo.setPassword(passWords);
            mOcKeysInfo.setKeystore(keyStoreJson);
            mOcKeysInfo.setCode(200);
        } catch (Exception e) {
            //密码错误等报错提示
            System.out.println("deKeyStore2Keys：" + e.toString());
            mOcKeysInfo.setMsg(e.toString());
            mOcKeysInfo.setCode(9999);
        }
        return mOcKeysInfo;
    }
}
