# Mac os Ventura 关闭 accent方言，长按不能连续输入问题

在之前的osx版本遇到长按开启方言输入，无法连续输入问题时

```shell
defaults write -g ApplePressAndHoldEnabled -bool false
```
通过关闭 ApplePressAndHoldEnabled来实现。


在Ventura中这个参数命名被改变，需要在Terminal中输入下面命令

```shell
defaults write NSGlobalDomain "ApplePressAndHoldEnabled" -bool "true" 
```

查看是否设置成功

```shell
defaults read NSGlobalDomain "ApplePressAndHoldEnabled"
```
如果得到 `0` 说明已经关闭

需要登出或者重新启动才可以生效
