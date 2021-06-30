package org.zxp.esclientrhl.demo.domain.test;

import lombok.Data;
import org.zxp.esclientrhl.annotation.ESID;
import org.zxp.esclientrhl.annotation.ESMapping;
import org.zxp.esclientrhl.annotation.ESMetaData;
import org.zxp.esclientrhl.enums.DataType;

import java.io.Serializable;

/**
 * @className: Person
 * @description: TODO 类描述
 * @author: leo.j
 * @date: 2021/6/26
 **/
@Data
@ESMetaData(indexName = "person_01")
public class Person implements Serializable {
    @ESID
    @ESMapping(datatype = DataType.long_type)
    private Long id;
    @ESMapping(datatype = DataType.integer_type)
    private Integer gender;
    @ESMapping(datatype = DataType.long_type)
    private Integer age;
    @ESMapping(datatype = DataType.text_type)
    private String name;
}
