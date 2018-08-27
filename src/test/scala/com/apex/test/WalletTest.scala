///*
// * Copyright  2018 APEX Technologies.Co.Ltd. All rights reserved.
// *
// * FileName: WalletTest.scala
// *
// * @author: shan.huang@chinapex.com: 2018-07-27 下午4:06@version: 1.0
// */
//
//package com.apex.test
//
//import com.apex.crypto.Ecdsa.PrivateKey
//import com.apex.crypto.{BinaryData, Crypto, Ecdsa}
//import org.junit.Test
//import com.apex.wallets.Wallet
//
//@Test
//class WalletTest {
//
//  @Test
//  def testToAddress = {
//    //val data = new Array[Byte](20)
//    //new SecureRandom().nextBytes(data)
//
//    //20 bytes data
//    val address1 = Wallet.toAddress(BinaryData("0000000000000000000000000000000000000000"))
//
//    //20 bytes data
//    val address2 = Wallet.toAddress(BinaryData("654a5851e9372b87810a8e60cdd2e7cfd80b6e31"))
//
//    //20 bytes data
//    val address3 = Wallet.toAddress(BinaryData("ffffffffffffffffffffffffffffffffffffffff"))
//
//    var privKey = new Ecdsa.PrivateKey(BinaryData("18e14a7b6a307f426a94f8114701e7c8e774e7f9a47e2c2035db29a206321725"))
//    var pubKey = privKey.publicKey
//    var pubKeyHash = pubKey.hash160  // f54a5851e9372b87810a8e60cdd2e7cfd80b6e31
//    val address4 = Wallet.toAddress(pubKeyHash)
//
//    assert(address1 == "AP1xWDozWvuVah1W86DKtcWzdw1LLHreMGX")
//    assert(address2 == "APBC5XmSaD4vooWo3FNho1wGAUyBQo3WCTQ")
//    assert(address3 == "APRJ7CvHoe5xTWSeD7dfD6eGRZWbGomzDi4")
//
//    assert(address4 == "APQKUqPcJEUwRdwoxpoGQnkrRGstSXkgebk")
//
//    //System.out.println(address)
//  }
//
//  @Test
//  def testToScriptHash = {
//    val hash = Wallet.toScriptHash("APBC5XmSaD4vooWo3FNho1wGAUyBQo3WCTQ").get
//    assert(hash.data sameElements BinaryData("654a5851e9372b87810a8e60cdd2e7cfd80b6e31"))
//  }
//
//  @Test
//  def testPrivKeyToWIF = {
//    val privKey = BinaryData("1e99423a4ed27608a15a2616a2b0e9e52ced330ac530edcc32c8ffc6a526aedd")
//    val wif = Wallet.privKeyToWIF(privKey)
//    assert(wif == "KxFC1jmwwCoACiCAWZ3eXa96mBM6tb3TYzGmf6YwgdGWZgawvrtJ")
//  }
//
//  @Test
//  def testGetPrivKeyFromWIF = {
//    val privKey = Wallet.getPrivKeyFromWIF("KxFC1jmwwCoACiCAWZ3eXa96mBM6tb3TYzGmf6YwgdGWZgawvrtJ").get
//    assert(privKey sameElements BinaryData("1e99423a4ed27608a15a2616a2b0e9e52ced330ac530edcc32c8ffc6a526aedd"))
//  }
//
//  @Test
//  def testKeyGen = {
//    println("======")
//    for (i <- 1 to 10) {
//      println(i)
//      val privateKey = new PrivateKey(BinaryData(Crypto.randomBytes(32)))
//      assert(privateKey.compressed == true)
//
//      print("priv key raw with 0x01: ")
//      println(privateKey.toString)   // 32 + 1
//
//      print("priv key WIF format:    ")
//      println(privateKey.toWIF)
//
//      print("pub key (compressed):   ")
//      println(privateKey.publicKey.toString)  // 1 + 32
//
//      print("pub key hash160:        ")
//      println(privateKey.publicKey.hash160.toString)
//
//      print("Address:                ")
//      println(privateKey.publicKey.toAddress)
//
//      println("======")
//    }
//    assert(true)
//  }
//
//}
