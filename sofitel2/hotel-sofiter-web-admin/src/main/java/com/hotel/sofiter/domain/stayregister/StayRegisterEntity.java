package com.hotel.sofiter.domain.stayregister;

import io.swagger.annotations.ApiModelProperty;

public class StayRegisterEntity {


        @ApiModelProperty("当前页码")
        private int pageNum;
        @ApiModelProperty("分页数")
        private int pageSize;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
}
