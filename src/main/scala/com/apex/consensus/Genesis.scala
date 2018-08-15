/*
 * Copyright  2018 APEX Technologies.Co.Ltd. All rights reserved.
 *
 * FileName: Genesis.scala
 *
 * @author: shan.huang@chinapex.com: 2018-08-15 下午4:06@version: 1.0
 */

package com.apex.consensus

import java.io.File
import com.apex.crypto.Ecdsa.{Point, PublicKey}
import com.typesafe.config.{Config, ConfigFactory}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ArbitraryTypeReader._
import net.ceedubs.ficus.readers.ValueReader

case class GenesisConfig( blockInterval: Int,
                          initialWitness: Array[WitnessInfo] )

case class WitnessInfo( name: String,
                        key: PublicKey)

object Genesis {

  implicit val publicKeyReader: ValueReader[PublicKey] = (cfg, path) => new PublicKey(Point(cfg.getString(path)))

  private def parseConfig(): GenesisConfig = {

    // FIXME: file path
    val cfg = ConfigFactory.parseFile(new File("src/main/resources/genesis.conf"))

    val config = cfg.as[GenesisConfig]("genesisConfig")

    config
  }

  final val config = parseConfig()
}


