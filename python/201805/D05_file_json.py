# coding=utf-8

import json

# 读取整个文件
def read_whole_file(fileName):
    with open(fileName) as fileObject:
        contents=fileObject.read()
    return contents

def read_ipynb_json(fileName):
    with open(fileName) as fileObject:
        data = json.load(fileObject)
        return data['cells'][2]['source'][0]
    return ""


def write_whole_file(fileContent, fileName):
    with open(fileName, 'w') as f:
        f.write(fileContent)

if __name__=="__main__":
    # s = read_whole_file("D05_file_json_plot_cv_predict.ipynb")
    # read_ipynb_json(s)
    data = read_ipynb_json("D05_file_json_plot_cv_predict.ipynb")
    write_whole_file(data, "D05_file_json_plot_cv_predict.py")
