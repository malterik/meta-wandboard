require recipes-kernel/linux/linux-yocto.inc

KERNEL_IMAGETYPE = "zImage"

COMPATIBLE_MACHINE = "wandboard"

RDEPENDS_kernel-base += "kernel-devicetree"

KERNEL_DEVICETREE = " \
    imx6q-wandboard.dtb \
    imx6q-wandboard-revb1.dtb \
    imx6dl-wandboard.dtb \
    imx6dl-wandboard-revb1.dtb \
 "

LINUX_VERSION = "4.2"
LINUX_VERSION_EXTENSION = "-jumpnow"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-4.2:"

S = "${WORKDIR}/git"

PR = "r1"

# v4.2.2
SRCREV = "7659db320e01bb0fc5f93724910fc6a7423ffe5a"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.2.y \
    file://defconfig \
 "

