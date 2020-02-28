from importNormativeTypes import *


#####################################################################################################################################################################################################
#																																		       														#
# Import Nfv Types from a given file																										   														#
# 																																			   														#
# activation :																																   														#
#       python importNfvTypes.py [optional -s <scheme> | --scheme=<scheme>, default http] [-i <be host> | --ip=<be host>] [-p <be port> | --port=<be port> ] [-f <input file> | --ifile=<input file> ] #
#																																		  	  														#
# shortest activation (be host = localhost, be port = 8080): 																				   														#
#		python importUsers.py [-f <input file> | --ifile=<input file> ]												 				           														#
#																																		       														#
#####################################################################################################################################################################################################

def importNfvTypes(scheme, be_host, be_port, admin_user, file_dir, update_version):
    nfv_types = ["underlayVpn",
                 "overlayTunnel",
                 "genericNeutronNet",
                 "allottedResource",
                 "extImageFile",
                 "extLocalStorage",
                 "extZteCP",
                 "extZteVDU",
                 "extZteVL",
                 "NSD",
                 "VDU",
                 "vduCompute",
                 "Cp",
                 "vduVirtualStorage",
                 "vduVirtualBlockStorage",
                 "vduVirtualFileStorage",
                 "vduVirtualObjectStorage",
                 "vduVirtualStorage",
                 "vnfVirtualLink",
                 "vnfExtCp",
                 "vduCp",
                 "VNF",
                 "PonUni",
                 "OltNni",
                 "OntNni"]

    response_codes = [200, 201]

    if update_version == 'false':
        response_codes = [200, 201, 409]

    results = []
    for nfv_type in nfv_types:
        result = createNormativeType(scheme, be_host, be_port, admin_user, file_dir, nfv_type, update_version)
        results.append(result)
        if result[1] is None or result[1] not in response_codes:
            print "Failed creating heat type " + nfv_type + ". " + str(result[1])
    return results


def main(argv):
    print 'Number of arguments:', len(sys.argv), 'arguments.'

    be_host = 'localhost'
    be_port = '8080'
    admin_user = 'jh0003'
    update_version = 'true'
    scheme = 'http'

    try:
        opts, args = getopt.getopt(argv, "i:p:u:v:h:", ["ip=", "port=", "user=", "updateversion="])
    except getopt.GetoptError:
        usage()
        error_and_exit(2, 'Invalid input')

    for opt, arg in opts:
        # print opt, arg
        if opt == '-h':
            usage()
            sys.exit(3)
        elif opt in ("-i", "--ip"):
            be_host = arg
        elif opt in ("-p", "--port"):
            be_port = arg
        elif opt in ("-u", "--user"):
            admin_user = arg
        elif opt in ("-s", "--scheme"):
            scheme = arg
        elif opt in ("-v", "--updateversion"):
            if arg.lower() == "false" or arg.lower() == "no":
                update_version = 'false'

    print 'scheme =', scheme, ',be host =', be_host, ', be port =', be_port, ', user =', admin_user

    if be_host is None:
        usage()
        sys.exit(3)

    results = importNfvTypes(scheme, be_host, be_port, admin_user, "../../../import/tosca/nfv-types/", update_version)

    print "-----------------------------"
    for result in results:
        print "{0:20} | {1:6}".format(result[0], result[1])
    print "-----------------------------"

    response_codes = [200, 201]

    if update_version == 'false':
        response_codes = [200, 201, 409]

    failed_normatives = filter(lambda x: x[1] is None or x[1] not in response_codes, results)
    if len(list(failed_normatives)) > 0:
        error_and_exit(1, None)
    else:
        error_and_exit(0, None)


if __name__ == "__main__":
    main(sys.argv[1:])
