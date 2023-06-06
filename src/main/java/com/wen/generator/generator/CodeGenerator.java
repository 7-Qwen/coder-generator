package com.wen.generator.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.*;


public class CodeGenerator {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
 
        /**
         * 全局配置，常用
         * 1.配置文件输出的路径OutputDir
         * 2.设置是否每次覆盖文件FileOverride
         * 3.mybatis的xml配置，如二级缓存，是否生成resultMap映射，是否生成columnlist的sql，这里没有使用xml，所以注释掉
         * 4.设置作者、是否使用swagger2等全局变量，其他变量参考官方文档
         * 5.自定义文件命名，%s是占位符，会将实体名替换进去
         */

        final GlobalConfig gc = new GlobalConfig();
        //needUpdate1
        gc.setOutputDir("E:\\abc_project_workspace\\temp_workSpace\\shopping_system\\shopping_system\\src\\main\\java");//输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        //gc.setEnableCache(false);// XML 二级缓存
        //gc.setBaseResultMap(true);// XML ResultMap
        //gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("7wen");// 作者
		gc.setSwagger2(true);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setControllerName("%sController");
//        gc.setServiceName("%sService");
        gc.setServiceImplName("Base%sService");
        gc.setEntityName("%s");
        gc.setFileOverride(true);
        gc.setMapperName("%sMapper");
        gc.setIdType(IdType.ASSIGN_UUID);
        mpg.setGlobalConfig(gc);
 
        /**
         * 包的配置，主要设置每一层的包名
         */
        final PackageConfig pc = new PackageConfig();
        //needUpdate2
        //设置包名
        pc.setParent("com.duqing.shopping_system");
//        pc.setController("system.web");
//        pc.setService("system.service");
        pc.setServiceImpl("service.baseService");
        pc.setMapper("dao");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);
 
        /**
         * 数据源配置，mybatis支持的数据库这里都支持
         */
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        //needUpdate3
        dsc.setUsername("root");
        dsc.setPassword("7wen");
        dsc.setUrl("jdbc:mysql://120.25.154.0:3306/work_bishe_leijunjie?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        mpg.setDataSource(dsc);
 
        /**
         * 输出模板，如果按照官方原生的可以不配置，也可以配置自定义的模板
         */
        TemplateConfig templateConfig = new TemplateConfig();

        //needUpdate4
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别，默认vm，xml不输出
        templateConfig.setEntity("tem/entity.java");
        templateConfig.setService(null);
        templateConfig.setServiceImpl("tem/serviceImpl.java");
        templateConfig.setController(null);
        templateConfig.setMapper("tem/mapper.java");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
 
        /**
         * 自定义配置，可以自定义参数在模板中使用，还可以已定义输出的文件，
         * 如果除了上面的几个模板之外还有其他的文件需要输出可以在这里设置
         */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("tableComment", "系统用户");
//                map.put("Handler", pc.getParent()+".system.handler");
//                map.put("SuperHandler", "com.code.generator.core.base.BaseHandler");
//                map.put("SuperHandlerName", "BaseHandler");
//                map.put("vo", pc.getParent()+".domain.vo");
//                this.setMap(map);
            }
        };
 
//        // 自定义输出配置
//        List<FileOutConfig> focList = new ArrayList<>();
//        // 自定义handler
//        focList.add(new FileOutConfig("myTemplates/handler.java.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return gc.getOutputDir() + "/com/code/generator/handler/"
//                        + tableInfo.getEntityName()+"Handler" + StringPool.DOT_JAVA;
//            }
//        });
//        // 自定义provider
//        focList.add(new FileOutConfig("myTemplates/provider.java.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return gc.getOutputDir() + "/com/code/generator/mapper/provider/"
//                        + tableInfo.getEntityName()+"Provider" + StringPool.DOT_JAVA;
//            }
//        });
//
//        // 自定义vo
//        focList.add(new FileOutConfig("myTemplates/vo.java.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return gc.getOutputDir() + "/com/code/generator/domain/vo/"
//                        + tableInfo.getEntityName()+"Vo" + StringPool.DOT_JAVA;
//            }
//        });
//
//        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
//
 
 
        /**
         * 生成策略配置，常用
         * 1.指定生成的表名
         * 2.表名前缀过滤
         * 3.实体名、字段名的命名方式
         * 4.指定继承的父类、父字段
         */

        StrategyConfig strategy = new StrategyConfig();
        //类名生成策略：驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //字段名生成方式：驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //needUpdate5
        strategy.setInclude(scanner("请输入要生成的表名,用逗号分割").split(","));
        strategy.setCapitalMode(true);
        strategy.setEntityLombokModel(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        //controller是否restful风格
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);
        // 执行生成
        mpg.execute();
 
    }

    /**
     * scanner
     * @author 7wen
     * @date 2022/4/8 13:59
     */
    private static String scanner(String msg) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        String result = "";
        if (scanner.hasNextLine()) {
            result = scanner.nextLine();
        }
        scanner.close();
        return result;
    }

}