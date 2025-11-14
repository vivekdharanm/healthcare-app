package com.healthcare_application.HealthCare.config;

private final String SECRET_KEY = "mysecretkey12345";
private final long EXPIRATION_MS = 86400000; // 1 day


public String generateToken(String username) 
{
	return Jwts.builder()
			.setSubject(username)
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
			.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
			.compact();
}


public Authentication getAuthentication(String token) 
{
	try 
	{
		String username = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
		return new UsernamePasswordAuthenticationToken(username, null, Collections.singletonList(new SimpleGrantedAuthority("USER")));
	} 
	catch (JwtException e) 
	{
		return null;
	}
}
