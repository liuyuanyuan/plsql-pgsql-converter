/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.barsopen.plsqlconverter.ast.transforms;

import java.util.List;
import org.antlr.runtime.tree.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.barsopen.plsqlconverter.Main;
import static ru.barsopen.plsqlconverter.ast.transforms.OracleOuterJoinTransformer.transformQueryBlock;
import ru.barsopen.plsqlconverter.ast.typed._baseNode;
import ru.barsopen.plsqlconverter.ast.typed.query_block;

/**
 *
 * @author Liu Yuanyuan
 */
public class Oracle2PGSyntaxTransformer
{

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void transformSyntax(_baseNode tree) throws Exception
    {
        logger.debug("Enter:tree=" + tree);
//        List<query_block> queryBlocks = AstUtil.getDescendantsOfType(tree, query_block.class);
//        for (query_block queryBlock : queryBlocks)
//        {
//            logger.debug("queryBlock=" + queryBlock);
//            try
//            {
//            } catch (Exception ex)
//            {
//                logger.error(ex.getMessage());
//                ex.printStackTrace();
//                throw new Exception(ex);
//            }
//        }       
    }

}
