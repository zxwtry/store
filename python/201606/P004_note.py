001 Python编译py成pyc和pyo
        python -m py_compile file.py
        python -m py_compile /root/src/{file1,file2}.py
    同样可以写一份脚本来完成
        import py_compile
        py_compile.compile("path")  //path是包含.py文件名的路径
    编译成pyo文件
        python -O -m py_compile file.py
        其中的-m相当于脚本中的import
        py_compile 相当于脚本中的import py_compile
        如果-O改成-OO则是删除相应的pyo文件
    编译成pyc文件
        pyc是一种二进制文件，是由py文件经过编译后，生成的文件，是一种
        byte code，py文件变成pyc文件后，加载速度提高。pyc是一种跨平台
        的字节码，是由python的虚拟机来执行。pyc的内容是跟python的版本
        相关的，不同版本的pyc文件是不同的，2.5编译的pyc文件是不可能在
        2.4的python执行的。
    什么是pyd文件
        pyd是python的动态链接库
    为什么需要pyc文件
        因为py文件可以直接看到源代码。当然pyc文件也是可以反编译的。
        
