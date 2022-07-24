DESCRIPTION = "Bundling the Zephyr application"
SECTION = "zirconium"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FIRMWARE = "zephyr-philosophers"
FIRMWARE_BLOB = "${FIRMWARE}.bin"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install[mcdepends] = "mc::zephyr-m4:${FIRMWARE}:do_deploy"

do_install() {
	install -d ${D}/firmware
	install -m 0755 ${TOPDIR}/tmp-colibri-imx7d-m4-newlib/deploy/images/colibri-imx7d-m4/${FIRMWARE_BLOB} ${D}/firmware
}

FILES:${PN}:append = " /firmware/${FIRMWARE_BLOB} "