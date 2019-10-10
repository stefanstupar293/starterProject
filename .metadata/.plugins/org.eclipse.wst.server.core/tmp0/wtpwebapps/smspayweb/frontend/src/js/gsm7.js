function UcmsGsm7Class()
{
	var gsm7_codepage = gsm7_codepage();

	this.gsm_text_info = function()
	{
		return(gsm_text_info.apply(this, arguments));
	};

	function init()
	{
		return(this);
	};

	function gsm_text_info(text)
	{
		var text_len			= text.length,
			gsm7_len			= 0,
			ucs2_len			= text_len,
			ucs4_len			= 0,
			gsm7_convertible	= true,
			gsm7_char			= null,
			gsm7_char_len		= 0,
			gsm7_buffer			= [] /*,
//			ucs2_buffer			= [],
			gsm7_codepoints		= [],
			ucs2_codepoints		= [],
			ucs4_codepoints		= [] */ ;

		for(var i = 0, c1, c2, cp; i < text_len; i++)
		{
			c1 = text.charCodeAt(i);

			cp = c1;

			if(c1 >= 0xD800 && c1 <= 0xDBFF) // high surrogate
			{
				if((i + 1) < text_len)
				{
					c2 = text.charCodeAt(i + 1);

					if(c2 >= 0xDC00 && c2 <= 0xDFFF) // low surrogate
					{
						cp = 0x10000 + (((c1 & 0x3FF) << 10) | (c2 & 0x3FF));

						i++;
					};
				};
			};

			//ucs4_len = ucs4_codepoints.push(cp);

			ucs4_len++;

			/*if(cp < 0x10000)
			{
				ucs2_len = ucs2_codepoints.push(c1);
			}
			else
			{
				ucs2_len = ucs2_codepoints.push(c1, c2);
			};*/

			if(cp in gsm7_codepage)
			{
				gsm7_char = gsm7_codepage[cp];
			}
			else
			{
				gsm7_convertible = false;

				gsm7_char = '?';
			};

			gsm7_char_len = gsm7_char.length;

			/*for(n = 0; n < gsm7_char_len; n++)
			{
				gsm7_codepoints.push(gsm7_char.charCodeAt(n));
			};*/

			gsm7_buffer.push(gsm7_char);

			gsm7_len += gsm7_char_len;
		};





		return({
			'gsm7_convertible'					: gsm7_convertible,
			'gsm7_encoded'						: gsm7_encoded						= gsm7_buffer.join(''),
			'gsm7_hex_encoded'					: gsm7_hex_encoded					= hex_encode(gsm7_encoded, false),
			'gsm7_bits_per_character'			: gsm7_bits_per_character			= 7,
			'gsm7_codepoints_per_sms'			: gsm7_codepoints_per_sms			= 147,
			'gsm7_codepoints_per_sms_useable'	: gsm7_codepoints_per_sms_useable	= ((gsm7_len > gsm7_codepoints_per_sms) ? 140 : gsm7_codepoints_per_sms),
			'gsm7_concatenated_sms'				: gsm7_concatenated_sms				= parseInt(Math.max(Math.ceil(gsm7_len / gsm7_codepoints_per_sms_useable), 1)),
			'gsm7_codepoints_used_total'		: gsm7_codepoints_used_total		= gsm7_len,
			'gsm7_codepoints_used'				: gsm7_codepoints_used				= gsm7_len - parseInt((gsm7_concatenated_sms - 1) * 140) - (((gsm7_len >= 148) && (gsm7_len <= 293)) ? 7 : 0),
			'gsm7_codepoints_left'				: gsm7_codepoints_left				= (((gsm7_len % gsm7_codepoints_per_sms_useable) > 0) ? gsm7_codepoints_per_sms_useable - (gsm7_len % gsm7_codepoints_per_sms_useable) : ((gsm7_len > 0) ? 0 : gsm7_codepoints_per_sms_useable)),

			'ucs2_encoded'						: ucs2_encoded						= text,
			'ucs2_hex_encoded'					: ucs2_hex_encoded					= hex_encode(ucs2_encoded, true),
			'ucs2_bits_per_character'			: ucs2_bits_per_character			= 16,
			'ucs2_codepoints_per_sms'			: ucs2_codepoints_per_sms			= 57,
			'ucs2_codepoints_per_sms_useable'	: ucs2_codepoints_per_sms_useable	= ((ucs2_len > ucs2_codepoints_per_sms) ?  54 : ucs2_codepoints_per_sms),
			'ucs2_concatenated_sms'				: ucs2_concatenated_sms				= parseInt(Math.max(Math.ceil(ucs2_len / ucs2_codepoints_per_sms_useable), 1)),
			'ucs2_codepoints_used_total'		: ucs2_codepoints_used_total		= ucs2_len,
			'ucs2_codepoints_used'				: ucs2_codepoints_used				= ucs2_len - parseInt((ucs2_concatenated_sms - 1) * 54) - (((ucs2_len >= 58) && (ucs2_len <= 121)) ? 3 : 0),
			'ucs2_codepoints_left'				: ucs2_codepoints_left				= (((ucs2_len % ucs2_codepoints_per_sms_useable) > 0) ? ucs2_codepoints_per_sms_useable - (ucs2_len % ucs2_codepoints_per_sms_useable) : ((ucs2_len > 0) ? 0 : ucs2_codepoints_per_sms_useable)),

			'characters_used_total'				: characters_used_total				= ucs4_len,
			'concatenated_sms'					: concatenated_sms					= (gsm7_convertible ? gsm7_concatenated_sms				: ucs2_concatenated_sms),

			'codepoints_per_sms'				: codepoints_per_sms				= (gsm7_convertible ? gsm7_codepoints_per_sms			: ucs2_codepoints_per_sms),
			'codepoints_per_sms_useable'		: codepoints_per_sms_useable		= (gsm7_convertible ? gsm7_codepoints_per_sms_useable	: ucs2_codepoints_per_sms_useable),
			'codepoints_used_total'				: codepoints_used_total				= (gsm7_convertible ? gsm7_codepoints_used_total		: ucs2_codepoints_used_total),
			'codepoints_used'					: codepoints_used					= (gsm7_convertible ? gsm7_codepoints_used				: ucs2_codepoints_used),
			'codepoints_left'					: codepoints_left					= (gsm7_convertible ? gsm7_codepoints_left				: ucs2_codepoints_left),
			'codepoints_encoded'				: codepoints_encoded				= (gsm7_convertible ? gsm7_encoded						: ucs2_encoded),
			'codepoints_hex_encoded'			: codepoints_hex_encoded			= (gsm7_convertible ? gsm7_hex_encoded					: ucs2_hex_encoded),

			'bits_per_sms'						: bits_per_sms						= 1120,
			'bits_per_sms_useable'				: bits_per_sms_useable				= ((concatenated_sms > 1) ? (bits_per_sms - 48) : bits_per_sms),
			'bits_per_character'				: bits_per_character				= (gsm7_convertible ? gsm7_bits_per_character : ucs2_bits_per_character),
			'bits_overhead'						: bits_overhead						= (gsm7_convertible ? concatenated_sms : 0),
			'bits_left'							: bits_left							= parseInt(codepoints_left * bits_per_character),
			'bits_used'							: bits_used							= parseInt(concatenated_sms * bits_per_sms_useable) - bits_left, //- bits_overhead

			'octets_per_sms'					: octets_per_sms					= parseInt(Math.floor((bits_per_sms / 8))),
			'octets_per_sms_useable'			: octets_per_sms_useable			= parseInt(Math.floor((bits_per_sms_useable / 8))),
			'octets_used'						: octets_used						= parseInt(Math.ceil((bits_used / 8))),
			'octets_left'						: octets_left						= parseInt(Math.floor((bits_left / 8)))
		});
	}

	function hex_encode(text, multibyte)
	{
		for(var i = 0, stack = [], code, b1, b2; i < text.length; i++)
		{
			code = text.charCodeAt(i);

			b1 = (code >> 8);
			b2 = (code & 0xFF);

			stack.push(
				((b1 || multibyte) ? ('0' + b1.toString(16)).slice(-2) : '')
				+
				((b1 && !multibyte) ? ' ' : '')
				+
				('0' + b2.toString(16)).slice(-2)
			);
		};

		return(stack.join(' '));
	};

	function gsm7_codepage()
	{
		return({
			// Basic Character Set
			0x0040 : "\x00", 0x00A3 : "\x01", 0x0024 : "\x02", 0x00A5 : "\x03", 0x00E8 : "\x04", 0x00E9 : "\x05", 0x00F9 : "\x06", 0x00EC : "\x07",
			0x00F2 : "\x08", 0x00E7 : "\x09", 0x000A : "\x0A", 0x00D8 : "\x0B", 0x00F8 : "\x0C", 0x000D : "\x0D", 0x00C5 : "\x0E", 0x00E5 : "\x0F",
			0x0394 : "\x10", 0x005F : "\x11", 0x03A6 : "\x12", 0x0393 : "\x13", 0x039B : "\x14", 0x03A9 : "\x15", 0x03A0 : "\x16", 0x03A8 : "\x17",
			0x03A3 : "\x18", 0x0398 : "\x19", 0x039E : "\x1A", 0x00A0 : "\x1B", 0x00C6 : "\x1C", 0x00E6 : "\x1D", 0x00DF : "\x1E", 0x00C9 : "\x1F",
			0x0020 : "\x20", 0x0021 : "\x21", 0x0022 : "\x22", 0x0023 : "\x23", 0x00A4 : "\x24", 0x0025 : "\x25", 0x0026 : "\x26", 0x0027 : "\x27",
			0x0028 : "\x28", 0x0029 : "\x29", 0x002A : "\x2A", 0x002B : "\x2B", 0x002C : "\x2C", 0x002D : "\x2D", 0x002E : "\x2E", 0x002F : "\x2F",
			0x0030 : "\x30", 0x0031 : "\x31", 0x0032 : "\x32", 0x0033 : "\x33", 0x0034 : "\x34", 0x0035 : "\x35", 0x0036 : "\x36", 0x0037 : "\x37",
			0x0038 : "\x38", 0x0039 : "\x39", 0x003A : "\x3A", 0x003B : "\x3B", 0x003C : "\x3C", 0x003D : "\x3D", 0x003E : "\x3E", 0x003F : "\x3F",
			0x00A1 : "\x40", 0x0041 : "\x41", 0x0042 : "\x42", 0x0043 : "\x43", 0x0044 : "\x44", 0x0045 : "\x45", 0x0046 : "\x46", 0x0047 : "\x47",
			0x0048 : "\x48", 0x0049 : "\x49", 0x004A : "\x4A", 0x004B : "\x4B", 0x004C : "\x4C", 0x004D : "\x4D", 0x004E : "\x4E", 0x004F : "\x4F",
			0x0050 : "\x50", 0x0051 : "\x51", 0x0052 : "\x52", 0x0053 : "\x53", 0x0054 : "\x54", 0x0055 : "\x55", 0x0056 : "\x56", 0x0057 : "\x57",
			0x0058 : "\x58", 0x0059 : "\x59", 0x005A : "\x5A", 0x00C4 : "\x5B", 0x00D6 : "\x5C", 0x00D1 : "\x5D", 0x00DC : "\x5E", 0x00A7 : "\x5F",
			0x00BF : "\x60", 0x0061 : "\x61", 0x0062 : "\x62", 0x0063 : "\x63", 0x0064 : "\x64", 0x0065 : "\x65", 0x0066 : "\x66", 0x0067 : "\x67",
			0x0068 : "\x68", 0x0069 : "\x69", 0x006A : "\x6A", 0x006B : "\x6B", 0x006C : "\x6C", 0x006D : "\x6D", 0x006E : "\x6E", 0x006F : "\x6F",
			0x0070 : "\x70", 0x0071 : "\x71", 0x0072 : "\x72", 0x0073 : "\x73", 0x0074 : "\x74", 0x0075 : "\x75", 0x0076 : "\x76", 0x0077 : "\x77",
			0x0078 : "\x78", 0x0079 : "\x79", 0x007A : "\x7A", 0x00E4 : "\x7B", 0x00F6 : "\x7C", 0x00F1 : "\x7D", 0x00FC : "\x7E", 0x00E0 : "\x7F",
			// Basic Character Set Extension
			0x000C : "\x1B\x0A",
			0x005E : "\x1B\x14",
			0x007B : "\x1B\x28",
			0x007D : "\x1B\x29",
			0x005C : "\x1B\x2F",
			0x005B : "\x1B\x3C",
			0x007E : "\x1B\x3D",
			0x005D : "\x1B\x3E",
			0x007C : "\x1B\x40",
			0x20AC : "\x1B\x65"
		});
	};

	return(init.apply(this, arguments));
};
