SUMMARY = "A console image"
HOMEPAGE = "http://www.jumpnowtek.com"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    tzdata \
"

EXTRA_TOOLS = " \
    binutils binutils-symlinks \
    bzip2 \
    chrony \
    coreutils \
    curl \
    diffutils \
    elfutils elfutils-binutils \
    dosfstools \
    e2fsprogs-mke2fs \
    ethtool \
    file \
    findutils \
    grep \
    i2c-tools \
    ifupdown \
    iperf3 \
    iproute2 \
    iptables \
    less \
    lsof \
    ltrace \
    netcat-openbsd \
    parted \
    procps \
    strace \
    sysfsutils \
    tcpdump \
    util-linux \
    util-linux-blkid \
    unzip \
    vim \
    wget \
    zip \
"

SECURITY_TOOLS = " \
    checksec \
    nmap \
    wireguard-tools \
"

SYSTEMD_STUFF = " \
    systemd-analyze \
    systemd-bash-completion \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${EXTRA_TOOLS} \
    ${SECURITY_TOOLS} \
    ${SYSTEMD_STUFF} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
    echo 'America/New_York' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

export IMAGE_BASENAME = "console-image"
