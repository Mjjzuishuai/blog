package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * (Mylog)实体类
 *
 * @author makejava
 * @since 2019-12-04 21:28:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Mylog implements Serializable {
    private static final long serialVersionUID = 218251512384190590L;

    private String id;

    private String adminname;

    private Date date;

    private String thing;

    private String flag;


}